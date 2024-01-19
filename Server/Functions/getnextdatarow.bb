Function getnextdatarow%(arg0%, arg1%, arg2%)
    Local local0%
    If (arg0 = $00) Then
        arg0 = currentstatementhandle
    EndIf
    If (arg0 <> $00) Then
        local0 = sqlite3_step(arg0)
        Select local0
            Case $64
                Return $01
            Case $65
                If (arg1 <> 0) Then
                    finalisesql(arg0, arg2)
                EndIf
                Return $00
            Default
                Return sqlite3_errorhasoccurred("GetNextDataRow", arg2, "")
        End Select
    Else
        Return $00
    EndIf
    Return $00
End Function
