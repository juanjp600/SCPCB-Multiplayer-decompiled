Function draw_remove%(arg0%, arg1%)
    player[arg0]\Field51 = (player[arg0]\Field51 + $01)
    Delete player[arg0]\Field43[arg1]
    Return $00
End Function
