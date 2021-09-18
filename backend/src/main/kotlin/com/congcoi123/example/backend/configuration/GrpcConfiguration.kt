package com.congcoi123.example.backend.configuration

import io.grpc.ServerBuilder
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder
import io.grpc.netty.shaded.io.netty.handler.ssl.SslProvider
import org.lognet.springboot.grpc.GRpcServerBuilderConfigurer
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.IOException

@Configuration
@EnableConfigurationProperties(GrpcProperty::class)
class GrpcConfiguration {

    @Bean
    fun serverBuilderConfigurer(grpcProperty: GrpcProperty): GRpcServerBuilderConfigurer =
        object : GRpcServerBuilderConfigurer() {
            override fun configure(serverBuilder: ServerBuilder<*>?) {
                super.configure(serverBuilder)
                try {
                    (serverBuilder as NettyServerBuilder).sslContext(sslContextConfiguration(grpcProperty))
                } catch (e: IOException) {
                    throw IllegalArgumentException("SSL cert or key files are missing", e)
                }
            }
        }

    private fun sslContextConfiguration(grpcProperty: GrpcProperty): SslContext {
        val ssl = grpcProperty.ssl
        val serverCertificate = ssl.serverCertificate
        val serverKey = ssl.serverKey

        return GrpcSslContexts.configure(
            SslContextBuilder.forServer(
                serverCertificate.file,
                serverKey.file
            ), SslProvider.OPENSSL
        ).startTls(true).build()
    }
}
