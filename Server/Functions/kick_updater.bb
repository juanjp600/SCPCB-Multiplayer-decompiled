Function kick_updater%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4.chatmessage
    If (((server\Field21 = $00) And (server\Field9 = $00)) <> 0) Then
        For local2 = $01 To server\Field11 Step $01
            If (playeroptimize[local2]\Field55 = $00) Then
                If (playeroptimize[local2]\Field25 = $01) Then
                    playeroptimize[local2]\Field70 = (millisecs() + $EA60)
                    local1 = (local1 + $01)
                    local0 = $01
                Else
                    If (((server\Field11 > $01) And (server\Field41 = $00)) <> 0) Then
                        If (local1 = (server\Field11 - $01)) Then
                            For local4 = Each chatmessage
                                If (local4\Field1 = "If you doesn't ready in 1 munite, then you will be kicked") Then
                                    local3 = $01
                                    Exit
                                EndIf
                            Next
                            If (local3 = $00) Then
                                addtexttochat("If you doesn't ready in 1 munite, then you will be kicked", playeroptimize[local2]\Field30)
                            EndIf
                            If (millisecs() > playeroptimize[local2]\Field70) Then
                                kick(playeroptimize[local2]\Field30, (playeroptimize[local2]\Field15 + " kicked due to inactive"))
                            EndIf
                        Else
                            playeroptimize[local2]\Field70 = (millisecs() + $EA60)
                        EndIf
                    EndIf
                    local0 = $00
                    Exit
                EndIf
            EndIf
        Next
        If (local0 = $00) Then
            gameinfo\Field5\Field2 = (millisecs() + $2904)
        EndIf
        If (((((millisecs() > gameinfo\Field5\Field2) Or (server\Field39 = $01)) Or shouldstartround) Or (server\Field11 >= server\Field53)) <> 0) Then
            server\Field9 = $01
            shouldstartround = $00
        EndIf
    EndIf
    Return $00
End Function
