Function lastdatabaseerrorcode%(arg0%)
    If (arg0 = $00) Then
        arg0 = currentdatabasehandle
    EndIf
    Return sqlite3_errcode(arg0)
    Return $00
End Function
