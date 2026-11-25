package com.vmuguerzac.bibliocampus_api.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmuguerzac.bibliocampus_api.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class LibroBusquedaImpl implements LibroBusqueda {
    @PersistenceContext 
    private EntityManager em;

    @Override
    public List<Libro> buscarLibro(String q, List<String> categorias, boolean soloDisponibles, String orden) {
        StringBuilder jpql = new StringBuilder("SELECT l FROM Libro l WHERE 1 = 1");
        Map<String, Object> parametros = new HashMap<>();

        if(q != null && !q.isBlank()){
            jpql.append(" AND (LOWER(l.titulo) LIKE :q) OR LOWER(l.autor) LIKE :q");
            parametros.put("q", "%" + q.trim().toLowerCase() + "%" );
        }
        if(categorias != null && !categorias.isEmpty()){
            jpql.append(" AND l.categoria IN :categorias");
            parametros.put("categorias", categorias);
        }
        if(soloDisponibles){
            jpql.append(" AND  l.copiasDisponibles > 0");
        }
        String criterio = (orden == null)?"titulo":orden;
        switch (criterio) {
            case "anio":
                jpql.append(" ORDER BY l.anio DESC");
                break;
            case "autor":
                jpql.append(" ORDER BY LOWER(l.autor)");
                break;
            default:
                jpql.append(" ORDER BY LOWER(l.titulo)");
                break;
        }
        TypedQuery<Libro> consulta = em.createQuery(jpql.toString(), Libro.class);
        parametros.forEach(consulta::setParameter);
        return consulta.getResultList();
    }

    
}
