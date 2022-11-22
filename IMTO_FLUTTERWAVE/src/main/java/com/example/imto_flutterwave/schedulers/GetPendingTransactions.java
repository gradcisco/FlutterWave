package com.example.imto_flutterwave.schedulers;

import com.example.imto_flutterwave.model.TransferResponse;
import com.example.imto_flutterwave.service.TransfersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class GetPendingTransactions {
    static Set<Integer> pendingTxns =new HashSet<>();
    static
    {
       pendingTxns.add(376595);   pendingTxns.add(376615);
    }
    @Autowired
    TransfersImpl transfers;
    @Scheduled(fixedDelayString = "${cron.fixed_delay}", initialDelayString = "${cron.initial_delay}")
    private void getTransactions() {

        for(int id : pendingTxns){
            try{
                TransferResponse transferResponse = transfers.getTransfer("" + id);
                System.out.println(transferResponse.getData().getStatus());
                //TO DO - Update txn status
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
