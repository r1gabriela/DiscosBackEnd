package com.cds.apirest.serviceImpl;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cds.apirest.dto.UsuarioDto;
import com.cds.apirest.entity.Usuario;
import com.cds.apirest.repository.UsuarioRepository;
import com.cds.apirest.security.UserDetailsServiceImpl;
import com.cds.apirest.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;
	
	private static Object principal;
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	 
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    private AuthenticationManager authenticationManager;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioDto cadastrar(UsuarioDto usuarioDto) {
		try {
			Usuario usuario = usuarioRepository.pesquisarUsuarioPorUsername(usuarioDto.getUsername());
			
			if(usuario == null) {
				usuario = new ModelMapper().map(usuarioDto, Usuario.class);
				usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
				usuario = usuarioRepository.save(usuario);
			}else {
				throw new Exception("Erro ao cadastrar usuário");
			}
			return usuarioDto;
				
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void autoLogin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            logger.debug(String.format("Auto login %s successfully!", username));
        }
	}

}
