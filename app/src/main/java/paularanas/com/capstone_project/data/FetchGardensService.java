package paularanas.com.capstone_project.data;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Paul Aranas on 6/5/2016.
 */
public class FetchGardensService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public FetchGardensService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
