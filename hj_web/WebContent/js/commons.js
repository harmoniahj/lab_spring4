/************************************************************************
 * 윈도우 팝업창 처리 구현
 * @param1 > 화면에 띄울 페이지의 url
 * @param2 > 팝업창의 가로
 * @param3 > 팝업창의세로
 ***********************************************************************/
function cmm_window_popup(url, popupwidth, popupheight, popupname) {
  Top = (widnow.screen.height-popupheight)/3;
  Left = (widnow.screen.width-popupwidth)/2;
  if(Top < 0) Top = 0;
  if(Left < 0) Left = 0;

  let options = "location = no, fullscreen = no, left = " + Left + ", top = " + Top;
  options += ", width = " + popupwidth + ", height = " + popupheight;
  popupname = window.open(url, popupname, options);
  popupname.focus();
}