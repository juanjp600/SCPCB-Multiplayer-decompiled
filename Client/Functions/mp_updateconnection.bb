Function mp_updateconnection%()
    ue_connection\Field2 = (ue_connection\Field2 + mp_gettimestep())
    ue_connection\Field3 = (ue_connection\Field3 + mp_gettimestep())
    If (245.0 < ue_connection\Field2) Then
        shutdownserver($04)
    Else
        mp_recvconnectionclient()
        If (70.0 < ue_connection\Field3) Then
            directconnect(ue_connection\Field0, ue_connection\Field1)
            ue_connection\Field3 = 0.0
        EndIf
    EndIf
    Return $00
End Function
