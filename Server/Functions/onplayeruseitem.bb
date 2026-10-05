Function onplayeruseitem%(arg0%, arg1$)
    Select lower(arg1)
        Case "scp500"
            If (player[arg0]\Field36 = model_035) Then
                Return $00
            EndIf
            player[arg0]\Field62 = 0.0
            giveplayerhealth(arg0, (Float (player[arg0]\Field98 + $64)), "")
        Case "veryfinefirstaid","firstaid","finefirstaid","firstaid2"
            If (player[arg0]\Field36 = model_035) Then
                Return $00
            EndIf
            player[arg0]\Field62 = 0.0
            giveplayerhealth(arg0, (Float player[arg0]\Field98), "")
        Case "scp035"
            If (player[arg0]\Field36 <> model_035) Then
                setplayertype(arg0, model_035)
            EndIf
    End Select
    Return $00
End Function
