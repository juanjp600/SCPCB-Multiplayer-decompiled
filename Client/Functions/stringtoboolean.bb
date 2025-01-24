Function stringtoboolean%(arg0$, arg1%)
    Select arg0
        Case "True","true","1"
            Return $01
        Case "False","false","0"
            Return $00
        Default
            Return arg1
    End Select
    Return $00
End Function
