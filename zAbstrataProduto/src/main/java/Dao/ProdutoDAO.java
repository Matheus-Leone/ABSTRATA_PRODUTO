package Dao;

import Model.Produto;

import javax.persistence.*;
import java.util.List;

//Gerencia as Entidades(Classes) no Banco de Dados
public class ProdutoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ProdutoDAO() {
        this.emf = Persistence.createEntityManagerFactory("LojaPU");
        this.em = emf.createEntityManager();
    }

    // Create (Salvar)
    public void salvar(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    // Read (Buscar todos os produtos)
    public List<Produto> buscarTodos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    // Read (Buscar produto por ID)
    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    // Update (Atualizar produto)
    public void atualizar(Produto produto) {
        em.getTransaction().begin();
        em.merge(produto); // Atualiza o produto no banco
        em.getTransaction().commit();
    }

    // Delete (Excluir produto por ID)
    public void deletar(Long id) {
        em.getTransaction().begin();
        Produto produto = em.find(Produto.class, id);
        if (produto != null) {
            em.remove(produto); // Remove o produto do banco
        }
        em.getTransaction().commit();
    }

    // Fechar conexões
    public void close() {
        em.close();
        emf.close();
    }
}
