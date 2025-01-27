Function mp_update%()
    Local local0.mp_player
    mp_updatetimestep()
    mp_updatepinging()
    mp_updatesoundchannels()
    mp_updatevoice()
    mp_updateshutdown()
    If (mp_getsocket() = $00) Then
        Return $00
    EndIf
    mp_updateplayers()
    If (mp_ishoster() <> 0) Then
        mp_postserverlogic()
        mp_sendgamedata()
        mp_recvserver()
        mp_auth()
        mp_updatetimeouts()
        mp_serverlogic()
    Else
        mp_recvclient()
        mp_sendmyplayerdata()
        ue_server\Field2 = (ue_server\Field2 + mp_gettimestep())
        If (70.0 <= ue_server\Field2) Then
            For local0 = Each mp_player
                playerconnectionlossing(local0)
            Next
        EndIf
        If (1050.0 < ue_server\Field2) Then
            shutdownserver($00)
        EndIf
    EndIf
    Return $00
End Function
