Function begintransaction%(arg0%, arg1%)
    If (arg0 = $00) Then
        arg0 = currentdatabasehandle
    EndIf
    If (arg0 <> $00) Then
        Return (executesql("BEGIN", arg0, arg1) = $00)
    Else
        Return $00
    EndIf
    Return $00
End Function
