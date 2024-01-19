Function se_isvalidscript%(arg0$, arg1$)
    Return (lower(right(arg0, len(arg1))) = arg1)
    Return $00
End Function
