Function updateblur%(arg0#)
    entityalpha(ark_blur_image, arg0)
    If (0.0 < arg0) Then
        copyrect($00, $00, graphicwidth, graphicheight, (Int (smallest_power_two_half - (Float (graphicwidth Sar $01)))), (Int (smallest_power_two_half - (Float (graphicheight Sar $01)))), backbuffer(), texturebuffer(ark_blur_texture, $00))
    EndIf
    Return $00
End Function
