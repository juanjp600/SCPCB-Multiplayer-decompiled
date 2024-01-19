Function getcolumnvalueasfloat#(arg0%, arg1%)
    If (arg1 = $00) Then
        arg1 = currentstatementhandle
    EndIf
    If (arg1 <> $00) Then
        Return sqlite3_column_double(arg1, arg0)
    Else
        Return 0.0
    EndIf
    Return 0.0
End Function
