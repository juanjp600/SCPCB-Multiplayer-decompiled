Function se_isvalidscript%(arg0$)
    Return ((lower(right(arg0, $04)) = ".gsc") Or (lower(right(arg0, $05)) = ".gscc"))
    Return $00
End Function
