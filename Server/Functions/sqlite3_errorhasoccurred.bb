Function sqlite3_errorhasoccurred%(arg0$, arg1%, arg2$)
    Local local0%
    If (arg1 <> 0) Then
        If (arg2 = "") Then
            arg2 = sqlite3_errmsg(local0)
        EndIf
        runtimeerror(((("Error in SQLite3 > " + arg0) + ": ") + arg2))
    EndIf
    Return $00
End Function
