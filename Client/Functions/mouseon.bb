Function mouseon%(arg0%, arg1%, arg2%, arg3%)
    Return ((((Float arg0) < mouseposx) And ((Float (arg0 + arg2)) > mouseposx)) And (((Float arg1) < mouseposy) And ((Float (arg1 + arg3)) > mouseposy)))
    Return $00
End Function
