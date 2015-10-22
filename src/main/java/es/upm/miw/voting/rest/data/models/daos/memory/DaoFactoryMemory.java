package es.upm.miw.voting.rest.data.models.daos.memory;

public class DaoFactoryMemory extends DaoFactory {

    private ThemeMemoryDao themeDao;

    private VoteDao voteDao;

    public DaoFactoryMemory() {
    }

    @Override
    public ThemeDao getThemeDao() {
        if (themeDao == null) {
            themeDao = new ThemeMemoryDao();
        }
        return themeDao;
    }

    @Override
    public VoteDao getVoteDao() {
        if (voteDao == null) {
            voteDao = new VoteMemoryDao();
        }
        return voteDao;
    }

}
