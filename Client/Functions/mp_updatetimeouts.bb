Function mp_updatetimeouts%()
    Local local0.mp_player
    For local0 = Each mp_player
        If (local0\Field5 > $01) Then
            local0\Field4\Field1 = (local0\Field4\Field1 + mp_gettimestep())
            If (70.0 <= local0\Field4\Field1) Then
                playerconnectionlossing(local0)
            EndIf
            If (1050.0 < local0\Field4\Field1) Then
                mp_server_disconnectplayer(local0, getlocalstring("broadcast", "to"))
            EndIf
        EndIf
    Next
    Return $00
End Function
