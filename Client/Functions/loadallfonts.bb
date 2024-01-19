Function loadallfonts%(arg0%)
    If (arg0 <> 0) Then
        initaafont()
    EndIf
    font1 = aaloadfont("GFX\font\cour\Courier New Rus.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 19.0))), $00, $00, $00, $02)
    font1_2 = aaloadfont("GFX\font\cour\Courier New Rus.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 28.0))), $00, $00, $00, $02)
    font2 = aaloadfont("GFX\font\courbd\Courier New Rus.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 58.0))), $00, $00, $00, $02)
    font3 = aaloadfont("GFX\font\DS-DIGI\DS-Digital.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 22.0))), $00, $00, $00, $02)
    font4 = aaloadfont("GFX\Font\DS-DIGI\DS-Digital.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 60.0))), $00, $00, $00, $02)
    font5 = aaloadfont("GFX\fOnt\Journal\Journal.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 58.0))), $00, $00, $00, $02)
    fontsl = aaloadfont("GFX\foNt\cour\Courier New Rus.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 16.0))), $00, $00, $00, $02)
    fontsl_1 = aaloadfont("GFX\fonT\cour\Courier New Rus.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 16.0))), $00, $00, $01, $02)
    fontservers = aaloadfont("GFX\foNt\cour\Courier New Rus.ttf", (Float (Int (((Float graphicheight) / 1024.0) * (1.0 / 0.0725)))), $00, $00, $00, $02)
    consolefont = aaloadfont("Blitz", (Float (Int (((Float graphicheight) / 1024.0) * 20.0))), $00, $00, $00, $01)
    fontres = aaloadfont("GFX\fonT\cour\Courier New Rus.ttf", (Float (Int (((Float graphicheight) / 1024.0) * 18.0))), $00, $00, $00, $02)
    Return $00
End Function
