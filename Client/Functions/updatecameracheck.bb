Function updatecameracheck%()
    If (((mp_getsocket() <> $00) And (mp_ishoster() = $00)) <> 0) Then
        Return $00
    EndIf
    If (((0.0 < mtfcamerachecktimer) And (6300.0 > mtfcamerachecktimer)) <> 0) Then
        mtfcamerachecktimer = (fps\Field7[$00] + mtfcamerachecktimer)
    ElseIf (6300.0 <= mtfcamerachecktimer) Then
        mtfcamerachecktimer = 0.0
        If (me\Field57 = $00) Then
            If (mtfcameracheckdetected <> 0) Then
                playannouncement((("SFX\Character\MTF\AnnouncCameraFound" + (Str rand($02, $01))) + ".ogg"), $01)
                me\Field57 = $01
                mtfcamerachecktimer = 4200.0
            Else
                playannouncement("SFX\Character\MTF\AnnouncCameraNoFound.ogg", $01)
            EndIf
        EndIf
        mtfcameracheckdetected = $00
        If (0.0 = mtfcamerachecktimer) Then
            me\Field57 = $00
        EndIf
    EndIf
    Return $00
End Function
