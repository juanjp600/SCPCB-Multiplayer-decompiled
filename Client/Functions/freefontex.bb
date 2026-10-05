Function freefontex%(arg0.fontdata)
    If (arg0 <> Null) Then
        If (arg0\Field0 <> $00) Then
            freefont(arg0\Field0)
        EndIf
        Delete arg0
    EndIf
    Return $00
End Function
