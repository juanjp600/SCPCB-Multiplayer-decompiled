Function cfg_findbool%(arg0$)
    If (lower(arg0) = "true") Then
        Return $01
    ElseIf (lower(arg0) = "false") Then
        Return $00
    EndIf
    Return (Int arg0)
    Return $00
End Function
