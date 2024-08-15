package com.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.reactive.function.client.DefaultReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.reactive.function.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.web.reactive.function.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.web.reactive.function.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.web.reactive.function.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.userinfo.OidcUserInfo;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilderForService2(ReactiveOAuth2AuthorizedClientManager authorizedClientManagerForService2) {
        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth2ForService2 =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManagerForService2);
        return WebClient.builder().baseUrl("https://service2-url.com").filter(oauth2ForService2);
    }

    @Bean
    public WebClient.Builder webClientBuilderForService3(ReactiveOAuth2AuthorizedClientManager authorizedClientManagerForService3) {
        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth2ForService3 =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManagerForService3);
        return WebClient.builder().baseUrl("https://service3-url.com").filter(oauth2ForService3);
    }

    @Bean
    public ReactiveOAuth2AuthorizedClientManager authorizedClientManagerForService2(OAuth2AuthorizedClientService authorizedClientServiceForService2) {
        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                .clientCredentials()
                .build();

        DefaultReactiveOAuth2AuthorizedClientManager manager = new DefaultReactiveOAuth2AuthorizedClientManager(
                authorizedClientServiceForService2,
                new InMemoryOAuth2AuthorizedClientService(authorizedClientServiceForService2)
        );

        manager.setAuthorizedClientProvider(authorizedClientProvider);
        return manager;
    }

    @Bean
    public ReactiveOAuth2AuthorizedClientManager authorizedClientManagerForService3(OAuth2AuthorizedClientService authorizedClientServiceForService3) {
        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                .clientCredentials()
                .build();

        DefaultReactiveOAuth2AuthorizedClientManager manager = new DefaultReactiveOAuth2AuthorizedClientManager(
                authorizedClientServiceForService3,
                new InMemoryOAuth2AuthorizedClientService(authorizedClientServiceForService3)
        );

        manager.setAuthorizedClientProvider(authorizedClientProvider);
        return manager;
    }
}
