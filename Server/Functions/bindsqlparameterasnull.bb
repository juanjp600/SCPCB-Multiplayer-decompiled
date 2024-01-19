Function bindsqlparameterasnull%(arg0%, arg1%)
    Local local0%
    Local local1%
    If (arg1 = $00) Then
        arg1 = currentstatementhandle
    EndIf
    If (arg1 <> $00) Then
        local0 = sqlite3_bind_null(arg1, arg0)
        If (local0 = $00) Then
            Return $01
        Else
            Return sqlite3_errorhasoccurred("BindParameterAsNull", local1, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
