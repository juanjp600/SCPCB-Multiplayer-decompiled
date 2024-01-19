Function onplayeruseitem%(arg0%, arg1$)
    Select lower(arg1)
        Case "scp500"
            If (player[arg0]\Field36 = model_035) Then
                Return $00
            EndIf
            player[arg0]\Field60 = 0.0
            giveplayerhealth(arg0, (Float (player[arg0]\Field96 + $C8)), "")
        Case "veryfinefirstaid"
            If (player[arg0]\Field36 = model_035) Then
                Return $00
            EndIf
            player[arg0]\Field60 = 0.0
            giveplayerhealth(arg0, (Float player[arg0]\Field96), "")
        Case "firstaid","finefirstaid","firstaid2"
            If (player[arg0]\Field36 = model_035) Then
                Return $00
            EndIf
            player[arg0]\Field60 = 0.0
            giveplayerhealth(arg0, (Float player[arg0]\Field96), "")
        Case "scp035"
            setplayertype(arg0, model_035)
    End Select
    Return $00
End Function
