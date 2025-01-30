Function updatedeaf%()
    If (0.0 < me\Field55) Then
        me\Field55 = max((me\Field55 - fps\Field7[$00]), 0.0)
        opt\Field16 = 0.0
    Else
        opt\Field16 = opt\Field17
        If (me\Field54 <> 0) Then
            controlsoundvolume()
            me\Field54 = $00
        EndIf
    EndIf
    Return $00
End Function
