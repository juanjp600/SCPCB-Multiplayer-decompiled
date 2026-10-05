Function spawnwave%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    local0 = rndseed()
    seedrnd(millisecs())
    local1 = $00
    local2 = $00
    local3 = $00
    local4 = rand($00, $01)
    For local5 = $01 To $41 Step $01
        If (player[local5] <> Null) Then
            If (player[local5]\Field36 = $00) Then
                local1 = (local1 + $01)
                local6 = (gameinfo\Field5\Field9 > $00)
                local7 = (gameinfo\Field5\Field10 > $00)
                If (((local6 = $00) And (local7 = $00)) <> 0) Then
                    Exit
                EndIf
                If (local4 = $00) Then
                    If (local6 <> 0) Then
                        setplayertype(local5, ntf_model)
                        gameinfo\Field5\Field9 = (gameinfo\Field5\Field9 - $01)
                        local2 = (local2 + $01)
                        local4 = $01
                    ElseIf (local7 <> 0) Then
                        setplayertype(local5, haos_model)
                        gameinfo\Field5\Field10 = (gameinfo\Field5\Field10 - $01)
                        local3 = (local3 + $01)
                    EndIf
                ElseIf (local7 <> 0) Then
                    setplayertype(local5, haos_model)
                    gameinfo\Field5\Field10 = (gameinfo\Field5\Field10 - $01)
                    local3 = (local3 + $01)
                    local4 = $00
                ElseIf (local6 <> 0) Then
                    setplayertype(local5, ntf_model)
                    gameinfo\Field5\Field9 = (gameinfo\Field5\Field9 - $01)
                    local2 = (local2 + $01)
                EndIf
            EndIf
        EndIf
    Next
    seedrnd(local0)
    gameinfo\Field5\Field5 = (millisecs() + rand($493E0, $61A80))
    Return $00
End Function
