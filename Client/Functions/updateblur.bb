Function updateblur%(arg0#)
    entityalpha(ark_blur_image, arg0)
    copyrect($00, $00, graphicwidth, graphicheight, ark_blur_x, ark_blur_y, backbuffer(), texturebuffer(ark_blur_texture, $00))
    Return $00
End Function
