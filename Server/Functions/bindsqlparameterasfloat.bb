Function bindsqlparameterasfloat%(arg0%, arg1#, arg2%)
    Local local0%
    Local local1%
    If (arg2 = $00) Then
        arg2 = currentstatementhandle
    EndIf
    If (arg2 <> $00) Then
        local0 = sqlite3_bind_double(arg2, arg0, arg1)
        If (local0 = $00) Then
            Return $01
        Else
            Return sqlite3_errorhasoccurred("BindParameterAsFloat", local1, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
