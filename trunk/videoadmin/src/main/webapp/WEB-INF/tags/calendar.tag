<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="name" required="true"%>

<input id="${id }" name="${name }" type="text"  size="15"  readonly="readonly" />
<img src="js/calendar/calendar.gif" onclick="fPopCalendar(event,document.getElementById('${id}'),document.getElementById('${id}'))" />
