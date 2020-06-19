package ssl.ois.timelog.adapter.rest.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssl.ois.timelog.adapter.presenter.log.history.LogHistoryPresenter;
import ssl.ois.timelog.adapter.view.model.log.history.LogHistoryViewModel;
import ssl.ois.timelog.service.log.history.HistoryLogUseCase;
import ssl.ois.timelog.service.log.history.HistoryLogUseCaseInput;
import ssl.ois.timelog.service.log.history.HistoryLogUseCaseOutput;
import ssl.ois.timelog.service.repository.log.LogRepository;

@RestController
@RequestMapping("/api/log/history")
public class LogHistoryAdapter {
    @Autowired
    private LogRepository logRepository;

    @PostMapping(value = "/")
    public ResponseEntity<LogHistoryViewModel> history(@RequestBody HistoryLogUseCaseInput input) {
        HistoryLogUseCase useCase = new HistoryLogUseCase(this.logRepository);
        LogHistoryPresenter output = new LogHistoryPresenter();

        useCase.execute(input, output);

        return ResponseEntity.status(HttpStatus.OK).body(output.build());
    }
}