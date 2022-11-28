package com.castillo.rentacar.Models;

public interface RevisionVehicular {
    boolean enRenta(String matricula);
    boolean enMantenimiento(String matricula);
    boolean reportadoPorRobo(String matricula);
    boolean kilometrajeRegistrado(long kilometraje);
}
