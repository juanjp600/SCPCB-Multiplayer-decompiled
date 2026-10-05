Function loadallfonts%()
    fonts[$00] = createfont("GFX\font\cour\Courier New.ttf", (Int (16.0 * menuscale)), $00, $00, $00)
    fonts[$01] = createfont("GFX\font\cour\Courier New.ttf", (Int (52.0 * menuscale)), $00, $00, $00)
    fonts[$02] = createfont("GFX\font\DS-DIGI\DS-Digital.ttf", (Int (20.0 * menuscale)), $00, $00, $00)
    fonts[$03] = createfont("GFX\font\DS-DIGI\DS-Digital.ttf", (Int (60.0 * menuscale)), $00, $00, $00)
    fonts[$04] = createfont("GFX\font\Journal\Journal.ttf", (Int (58.0 * menuscale)), $00, $00, $00)
    fonts[$05] = createfont(fontpath("Consolas"), (Int (16.0 * menuscale)), $00, $00, $00)
    fonts[$06] = createfont("GFX\font\cour\Courier New.ttf", $31, $00, $00, $00)
    Return $00
End Function
