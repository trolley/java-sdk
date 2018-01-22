package ca.paymentrails.paymentrails.unit;

import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.when;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ca.paymentrails.paymentrails.*;
import java.util.List;
import java.util.ArrayList;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Batch.class)
public class BatchTest {

    @Test
    public void testRetrieveBatch() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        when(Batch.find(batch_id)).thenReturn(fakeGet(batch_id));

        Batch response = Batch.find(batch_id);

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.getId());
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveBatchInvalidBatchId() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = "91XQ4VKD39C3P";
        when(Batch.find(batch_id)).thenReturn(fakeGet(batch_id));

        Batch.find(batch_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrieveBatchNullBatchId() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = null;
        when(Batch.find(batch_id)).thenReturn(fakeGet(batch_id));

        Batch.find(batch_id);

    }

    @Test
    public void testUpdateBatch() throws Exception {

        PowerMockito.mockStatic(Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        String body = "{\"update_payments\":[{\"id\":\"P-91XQ2ZGK7HM62\"," + "\"sourceAmount\":999}]}";
        when(Batch.update(batch_id, body)).thenReturn(fakePatch(batch_id, body));

        String response = Batch.update(batch_id, body);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateBatchInvalidBatchId() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = "91XQ4VKD39C3P";
        String body = "{\"update_payments\":[{\"id\":\"P-91XQ2ZGK7HM62\"," + "\"sourceAmount\":999}]}";
        when(Batch.update(batch_id, body)).thenReturn(fakePatch(batch_id, body));

        Batch.update(batch_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdateBatchNullBatchId() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = null;
        String body = "{\"update_payments\":[{\"id\":\"P-91XQ2ZGK7HM62\"," + "\"sourceAmount\":999}]}";
        when(Batch.update(batch_id, body)).thenReturn(fakePatch(batch_id, body));

        Batch.update(batch_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdateBatchNullBody() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        String body = null;
        when(Batch.update(batch_id, body)).thenReturn(fakePatch(batch_id, body));

        Batch.update(batch_id, body);
    }

    @Test
    public void testDeleteBatch() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        when(Batch.delete(batch_id)).thenReturn(fakeDelete(batch_id));

        String response = Batch.delete(batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteBatchInvalidBatchId() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = "91XQ4VKD39C3P";
        when(Batch.delete(batch_id)).thenReturn(fakeDelete(batch_id));

        Batch.delete(batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testDeleteBatchNullBatchId() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = null;
        when(Batch.delete(batch_id)).thenReturn(fakeDelete(batch_id));

        Batch.delete(batch_id);
    }

    @Test
    public void testListBatchesWithQueries() throws Exception {
        PowerMockito.mockStatic(Batch.class);

        when(Batch.query(1, 10, "f18")).thenReturn(fakeQuery(1, 10, "f18"));

        List<Batch> response = Batch.query(1, 10, "f18");

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.get(0).getId());
    }

    @Test(expected = InvalidFieldException.class)
    public void testListBatchesWithQueriesNegativePage() throws Exception {
        PowerMockito.mockStatic(Batch.class);

        when(Batch.query(-1, 10, "f18")).thenReturn(fakeQuery(-1, 10, "f18"));

        Batch.query(-1, 10, "f18");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListBatchesWithQueriesNegativePageSize() throws Exception {
        PowerMockito.mockStatic(Batch.class);

        when(Batch.query(1, -10, "f18")).thenReturn(fakeQuery(1, -10, "f18"));

        Batch.query(1, -10, "f18");

    }

    @Test(expected = InvalidFieldException.class)
    public void testListBatchesWithQueriesNullTerme() throws Exception {
        PowerMockito.mockStatic(Batch.class);

        when(Batch.query(1, 10, null)).thenReturn(fakeQuery(1, 10, null));

        Batch.query(1, 10, null);

    }

    @Test
    public void testBatchSummary() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        when(Batch.summary(batch_id)).thenReturn(fakeSummary(batch_id));
        BatchSummary response = Batch.summary(batch_id);
        PowerMockito.verifyStatic();
        assertEquals("10", response.total.sendingAmount);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testBatchSummaryInvalidBatchId() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = "91XQ4VKD39C3P";
        when(Batch.summary(batch_id)).thenReturn(fakeSummary(batch_id));

        Batch.summary(batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testBatchSummaryNullBatchId() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String batch_id = null;
        when(Batch.summary(batch_id)).thenReturn(fakeSummary(batch_id));

        Batch.summary(batch_id);

    }

    @Test
    public void testCreateBatch() throws Exception {

        PowerMockito.mockStatic(Batch.class);
        String body = "{\"payments\":[{\"recipient\":{\"id\":\"R-912Q4JHD6RH7E\"},\"sourceAmount\":\"65\",\"memo\":\"\",\"sourceCurrency\":\"CAD\"}]}";

        when(Batch.create(body)).thenReturn(fakePost(body));

        Batch response = Batch.create(body);
        assertEquals("1A2B3C", response.getId());

        String batch_id = "B-fhfhfh";//response.substring(26, 41);

        when(Batch.generateQuote(batch_id)).thenReturn(fakeGenerateQuote(batch_id));
        String response1 = Batch.generateQuote(batch_id);
        String result1 = response1.substring(6, 10);
        assertEquals("true", result1);

        when(Batch.processBatch(batch_id)).thenReturn(fakeProcessBatch(batch_id));
        String response2 = Batch.processBatch(batch_id);
        String result2 = response2.substring(6, 10);
        assertEquals("true", result2);
    }

    @Test(expected = InvalidFieldException.class)
    public void testCreateBatchNullBody() throws Exception {
        PowerMockito.mockStatic(Batch.class);
        String body = null;

        when(Batch.create(body)).thenReturn(fakePost(body));

        Batch.create(body);

    }

    private Batch fakeGet(String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        Batch batch = new Batch();
        batch.setId("1A2B3C");
        return batch;
    }

    private Batch fakePost(String body) throws InvalidFieldException, InvalidStatusCodeException {

        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        Batch batch = new Batch();
        batch.setId("1A2B3C");
        return batch;
    }

    private String fakePatch(String batch_id, String body) throws InvalidFieldException, InvalidStatusCodeException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"object\":\"updated\"}";
    }

    private String fakeDelete(String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"object\":\"deleted\"}";
    }

    private List<Batch> fakeQuery(int page, int pageSize, String term) throws InvalidFieldException {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less then 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less then 0");
        }
        if (term == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        List<Batch> batches = new ArrayList<Batch>();
        Batch batch = new Batch();
        batch.setId("1A2B3C");
        batches.add(batch);
        return batches;
    }

    private BatchSummary fakeSummary(String batch_id) throws InvalidFieldException, InvalidStatusCodeException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        BatchSummary batchSummary = new BatchSummary();
        Total total = new Total();
        total.sendingAmount = "10";
        batchSummary.total = total;
        return batchSummary;
    }

    private String fakeGenerateQuote(String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"batch\":{\"id\":\"B-91XQ2ZGK7DKMJ\",\"status\":\"open\",\"amount\":\"900.90\",\"totalPayments\":\"1\",\"currency\":\"USD\",\"description\":\"Weekly Payouts on 2017-4-8\",\"sentAt\":null,\"completedAt\":null,\"createdAt\":\"2017-05-08T17:09:04.889Z\",\"updatedAt\":\"2017-05-17T15:00:14.262Z\"}}";
    }

    private String fakeProcessBatch(String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"batch\":{\"id\":\"B-91XQ2ZGK7DKMJ\",\"status\":\"processing\",\"amount\":\"900.90\",\"totalPayments\":1,\"currency\":\"USD\",\"description\":\"Weekly Payouts on 2017-4-8\",\"sentAt\":\"2017-05-17T15:00:49.458Z\",\"completedAt\":null,\"createdAt\":\"2017-05-08T17:09:04.889Z\",\"updatedAt\":\"2017-05-17T15:00:49.459Z\"}}";
    }

}
