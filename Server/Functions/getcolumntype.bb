Function getcolumntype%(arg0%, arg1%)
    If (arg1 = $00) Then
        arg1 = currentstatementhandle
    EndIf
    If (arg1 <> $00) Then
        Return sqlite3_column_type(arg1, arg0)
    Else
        Return $00
    EndIf
    Return $00
End Function
