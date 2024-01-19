Function spawnmtf%()
    Local local0%
    Local local1%[65]
    Local local2%
    Local local3%
    Local local5%
    gameinfo\Field5\Field9 = min(max(gameinfo\Field5\Field9, 0.0), (Float server\Field18))
    gameinfo\Field5\Field10 = min(max(gameinfo\Field5\Field10, 0.0), (Float server\Field18))
    local0 = $00
    For local3 = $01 To server\Field11 Step $01
        If (playeroptimize[local3]\Field36 = $00) Then
            local1[local2] = playeroptimize[local3]\Field30
            local2 = (local2 + $01)
        EndIf
    Next
    If (local2 > $01) Then
        If ((((gameinfo\Field5\Field8 = $00) And (1.0 > gameinfo\Field5\Field9)) Or ((gameinfo\Field5\Field8 = $01) And (1.0 > gameinfo\Field5\Field10))) <> 0) Then
            gameinfo\Field5\Field8 = (gameinfo\Field5\Field8 = $00)
        EndIf
        If (((1.0 <= gameinfo\Field5\Field10) Or (1.0 <= gameinfo\Field5\Field9)) <> 0) Then
            If (((1.0 > gameinfo\Field5\Field9) And (8.0 > gameinfo\Field5\Field10)) <> 0) Then
                gameinfo\Field5\Field10 = 8.0
                gameinfo\Field5\Field8 = $01
            EndIf
            Select gameinfo\Field5\Field8
                Case $00
                    If ((Float server\Field67) <= gameinfo\Field5\Field9) Then
                        local0 = (Int (gameinfo\Field5\Field9 - (Float server\Field67)))
                    Else
                        local0 = $00
                    EndIf
                    local5 = $00
                    While (1.0 <= gameinfo\Field5\Field9)
                        local5 = rand($00, (local2 - $01))
                        setplayertype(local1[local5], ntf_model)
                        If (local2 >= $01) Then
                            local1[local5] = local1[(local2 - $01)]
                            local2 = (local2 - $01)
                            If (local2 < $01) Then
                                Exit
                            EndIf
                        EndIf
                        gameinfo\Field5\Field9 = (gameinfo\Field5\Field9 - 1.0)
                        If ((Float local0) > gameinfo\Field5\Field9) Then
                            Exit
                        EndIf
                    Wend
                Case $01
                    If ((Float server\Field67) <= gameinfo\Field5\Field10) Then
                        local0 = (Int (gameinfo\Field5\Field10 - (Float server\Field67)))
                    Else
                        local0 = $00
                    EndIf
                    local5 = $00
                    While (1.0 <= gameinfo\Field5\Field10)
                        local5 = rand($00, (local2 - $01))
                        setplayertype(local1[local5], haos_model)
                        If (local2 >= $01) Then
                            local1[local5] = local1[(local2 - $01)]
                            local2 = (local2 - $01)
                            If (local2 < $01) Then
                                Exit
                            EndIf
                        EndIf
                        gameinfo\Field5\Field10 = (gameinfo\Field5\Field10 - 1.0)
                        If ((Float local0) > gameinfo\Field5\Field10) Then
                            Exit
                        EndIf
                    Wend
            End Select
        EndIf
    EndIf
    If (getscripts() <> 0) Then
        Select gameinfo\Field5\Field8
            Case $00
                public_inqueue($33, $00)
            Case $01
                public_inqueue($34, $00)
        End Select
        callback($00)
    EndIf
    If (((se_getreturnvalue() = "0") Or (se_getreturnvalue() = "-1")) <> 0) Then
        If (gameinfo\Field5\Field8 <> $01) Then
            For local3 = $01 To server\Field11 Step $01
                udp_writebyte($33)
                udp_writebyte(playeroptimize[local3]\Field30)
                udp_sendmessage(playeroptimize[local3]\Field30)
            Next
        EndIf
    EndIf
    gameinfo\Field5\Field5 = (millisecs() + rand($493E0, $61A80))
    gameinfo\Field5\Field8 = (gameinfo\Field5\Field8 = $00)
    Return $00
End Function
