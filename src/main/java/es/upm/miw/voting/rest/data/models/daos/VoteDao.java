package es.upm.miw.voting.rest.data.models.daos;

import java.util.List;

import es.upm.miw.voting.rest.business.models.Theme;
import es.upm.miw.voting.rest.business.models.Vote;

public interface VoteDao {

    List<Vote> findByTheme(Theme theme);

}
