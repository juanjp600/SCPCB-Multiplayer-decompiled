Function mp_playsoundat%(arg0$, arg1%, arg2#, arg3#)
    mp_playsound(arg0, arg2, arg3, $00, $00, $01, $00, entityx(arg1, $01), entityy(arg1, $01), entityz(arg1, $01))
    Return $00
End Function
