package cys.partner.api.config;

import cys.partner.api.utils.JwtTokenUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilter {

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = jwtTokenUtil.resolveToken((HttpServletRequest) request);

        // token 존재시 로직처리
        if(token != null){

        }

        chain.doFilter(request, response);
    }
}
