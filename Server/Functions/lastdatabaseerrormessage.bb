Function lastdatabaseerrormessage$(arg0%)
    If (arg0 = $00) Then
        arg0 = currentdatabasehandle
    EndIf
    Return ""
    Return sqlite3_errmsg(arg0)
    Return ""
End Function
