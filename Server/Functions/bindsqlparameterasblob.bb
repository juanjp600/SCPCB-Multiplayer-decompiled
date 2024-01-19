Function bindsqlparameterasblob%(arg0%, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    If (arg3 = $00) Then
        arg3 = currentstatementhandle
    EndIf
    If (arg3 <> $00) Then
        local0 = sqlite3_bind_blob(arg3, arg0, arg1, arg2, $00)
        If (local0 = $00) Then
            Return $01
        Else
            Return sqlite3_errorhasoccurred("BindParameterAsBlob", local1, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
