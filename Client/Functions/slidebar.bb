Function slidebar#(arg0%, arg1%, arg2%, arg3#, arg4%)
    If ((mousedown1 And (onsliderid = $00)) <> 0) Then
        If (((((scaledmousex() >= arg0) And (scaledmousex() <= ((arg0 + arg2) + $0E))) And (scaledmousey() >= arg1)) And (scaledmousey() <= (arg1 + $14))) <> 0) Then
            arg3 = min(max((Float (((scaledmousex() - arg0) * $64) / arg2)), 0.0), 100.0)
        EndIf
    EndIf
    color($FF, $FF, $FF)
    rect(arg0, arg1, (arg2 + $0E), $14, $00)
    drawimage(blinkmeterimg, (Int (((((Float arg2) * arg3) / 100.0) + (Float arg0)) + 3.0)), (arg1 + $03), $00)
    If (arg4 <> 0) Then
        color($AA, $AA, $AA)
        aatext((Int ((Float arg0) - (50.0 * menuscale))), (Int ((4.0 * menuscale) + (Float arg1))), "LOW", $00, $00, 1.0)
        aatext((Int ((38.0 * menuscale) + (Float (arg0 + arg2)))), (Int ((4.0 * menuscale) + (Float arg1))), "HIGH", $00, $00, 1.0)
    EndIf
    Return arg3
    Return 0.0
End Function
