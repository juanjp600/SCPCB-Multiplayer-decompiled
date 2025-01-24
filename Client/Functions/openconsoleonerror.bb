Function openconsoleonerror%(arg0$)
    If (((((menuopen Lor consoleopen) Lor (opt\Field34 = $00)) Lor (opt\Field31 = $00)) Lor (ue_server\Field11 = $00)) <> 0) Then
        Return $00
    EndIf
    If ((millisec Mod $5DC) < $320) Then
        If (arg0 <> "") Then
            createconsolemsg(arg0, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        EndIf
        consoleopen = $01
    EndIf
    Return $00
End Function
