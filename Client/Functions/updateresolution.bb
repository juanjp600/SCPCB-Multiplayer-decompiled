Function updateresolution%(arg0%, arg1%)
    Local local0$
    Local local1%
    If (updatefocus() = $00) Then
        delay($32)
    EndIf
    If (arg0 <> 0) Then
        If (turnongamma = $00) Then
            If (borderlesswindowed <> 0) Then
                If (((realgraphicwidth <> graphicwidth) Or (realgraphicheight <> graphicheight)) <> 0) Then
                    setbuffer(texturebuffer(fresize_texture, $00))
                    clscolor($00, $00, $00)
                    cls()
                    copyrect($00, $00, graphicwidth, graphicheight, (Int (smallest_power_two_half - (Float (graphicwidth Sar $01)))), (Int (smallest_power_two_half - (Float (graphicheight Sar $01)))), backbuffer(), texturebuffer(fresize_texture, $00))
                    setbuffer(backbuffer())
                    clscolor($00, $00, $00)
                    cls()
                    scalerender(0.0, 0.0, ((smallest_power_two / (Float graphicwidth)) * aspectratioratio), ((smallest_power_two / (Float graphicwidth)) * aspectratioratio))
                EndIf
            EndIf
            If (1.0 <= screengamma) Then
                copyrect($00, $00, realgraphicwidth, realgraphicheight, (Int (smallest_power_two_half - (Float (realgraphicwidth Sar $01)))), (Int (smallest_power_two_half - (Float (realgraphicheight Sar $01)))), backbuffer(), texturebuffer(fresize_texture, $00))
                entityblend(fresize_image, $01)
                clscolor($00, $00, $00)
                cls()
                scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicwidth)))
                entityfx(fresize_image, $21)
                entityblend(fresize_image, $03)
                entityalpha(fresize_image, (screengamma - 1.0))
                scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicwidth)))
            ElseIf (1.0 > screengamma) Then
                copyrect($00, $00, realgraphicwidth, realgraphicheight, (Int (smallest_power_two_half - (Float (realgraphicwidth Sar $01)))), (Int (smallest_power_two_half - (Float (realgraphicheight Sar $01)))), backbuffer(), texturebuffer(fresize_texture, $00))
                entityblend(fresize_image, $01)
                clscolor($00, $00, $00)
                cls()
                scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicwidth)))
                entityfx(fresize_image, $21)
                entityblend(fresize_image, $02)
                entityalpha(fresize_image, 1.0)
                setbuffer(texturebuffer(fresize_texture2, $00))
                clscolor((Int (255.0 * screengamma)), (Int (255.0 * screengamma)), (Int (255.0 * screengamma)))
                cls()
                setbuffer(backbuffer())
                scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicwidth)), (smallest_power_two / (Float realgraphicwidth)))
                setbuffer(texturebuffer(fresize_texture2, $00))
                clscolor($00, $00, $00)
                cls()
                setbuffer(backbuffer())
            EndIf
        Else
            If (camera <> $00) Then
                hideentity(camera)
            EndIf
            renderworld(1.0)
            If (camera <> $00) Then
                showentity(camera)
            EndIf
        EndIf
        entityfx(fresize_image, $01)
        entityblend(fresize_image, $01)
        entityalpha(fresize_image, 1.0)
    EndIf
    If (((infocus Or borderlesswindowed) Or (fullscreen = $00)) <> 0) Then
        If (arg1 = $FFFFFFFF) Then
            flip(verticalsync)
        Else
            flip(arg1)
        EndIf
    EndIf
    If ((shouldrestartserver And udp_getstream()) <> 0) Then
        local0 = dottedip(udp_network\Field7)
        local1 = udp_network\Field8
        disconnectserver("Restarting", $01)
        restartingserver(local0, local1)
        shouldrestartserver = $00
    Else
        shouldrestartserver = $00
    EndIf
    Return $00
End Function
