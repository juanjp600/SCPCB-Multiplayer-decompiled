Function preparesql%(arg0$, arg1%, arg2%, arg3%)
    Local local0.databasehandlecontainer
    Local local1%
    Local local2%
    If (arg1 = $00) Then
        arg1 = currentdatabasehandle
    EndIf
    If (arg1 <> $00) Then
        local0 = (New databasehandlecontainer)
        local1 = sqlite3_prepare(arg1, arg0, len(arg0), local0, $00)
        local2 = local0\Field0
        Delete local0
        If (local1 = $00) Then
            If (arg2 <> 0) Then
                currentstatementhandle = local2
            EndIf
            Return local2
        Else
            Return sqlite3_errorhasoccurred("PrepareSQL", arg3, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
