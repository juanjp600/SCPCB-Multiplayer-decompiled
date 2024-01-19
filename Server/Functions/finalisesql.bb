Function finalisesql%(arg0%, arg1%)
    Local local0%
    If (arg0 = $00) Then
        arg0 = currentstatementhandle
    EndIf
    If (arg0 <> $00) Then
        local0 = sqlite3_finalize(arg0)
        If (local0 = $00) Then
            If (arg0 = currentstatementhandle) Then
                currentstatementhandle = $00
            EndIf
            Return $01
        Else
            Return sqlite3_errorhasoccurred("FinaliseSQL", arg1, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
