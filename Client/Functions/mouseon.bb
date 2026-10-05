Function mouseon%(arg0%, arg1%, arg2%, arg3%)
    Return ((((mouseposx > arg0) And (mouseposx < (arg0 + arg2))) And (mouseposy > arg1)) And (mouseposy < (arg1 + arg3)))
    Return $00
End Function
